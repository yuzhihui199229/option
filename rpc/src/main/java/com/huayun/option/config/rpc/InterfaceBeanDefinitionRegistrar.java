package com.huayun.option.config.rpc;

import com.huayun.option.annotation.EnableRpcClient;
import com.huayun.option.annotation.RpcProxy;
import com.huayun.option.model.ParseType;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: yuzh
 * Date: 2021/8/24
 * Description:
 */
@Configuration
public class InterfaceBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        ClassPathScanningCandidateComponentProvider scan = getScanner();

        // 扫描带ProtobufProxy注解的接口
        scan.addIncludeFilter(new AnnotationTypeFilter(RpcProxy.class));

        //候补符合条件的组件
        Set<BeanDefinition> candidateComponents = new HashSet<>();
        for (String basePackage : getBasePackages(annotationMetadata)) {
            candidateComponents.addAll(scan.findCandidateComponents(basePackage));
        }

        for (BeanDefinition candidateComponent : candidateComponents) {
            if (!beanDefinitionRegistry.containsBeanDefinition(candidateComponent.getBeanClassName())) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
                    Assert.isTrue(metadata.isInterface(), "can only be specified on an interface");
                    //缓存服务
                    cacheService(annotatedBeanDefinition);
                    Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(RpcProxy.class.getCanonicalName());
                    //注册nettyRpcClient的方法
                    registerNettyRpcClient(beanDefinitionRegistry, metadata, annotationAttributes);
                }
            }
        }

    }

    private void cacheService(AnnotatedBeanDefinition annotatedBeanDefinition) {
        String interfaceName = annotatedBeanDefinition.getBeanClassName();
        AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(RpcProxy.class.getCanonicalName());
//        String msgId = ((MsgId)(annotationAttributes.get("msgId"))).name();
        String parseType = ((ParseType)(annotationAttributes.get("parseType"))).name();
        ChannelPool.addService(interfaceName +"-"+parseType);
    }

    private void registerNettyRpcClient(BeanDefinitionRegistry beanDefinitionRegistry, AnnotationMetadata metadata, Map<String, Object> annotationAttributes) {
        String className = metadata.getClassName();

        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(ClientFactoryBean.class);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        definition.addPropertyValue("type", className);
        String name = annotationAttributes.get("name") == null ? "" : (String) (annotationAttributes.get("name"));
        // 别名
        String alias = name + "RpcClient";
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
        beanDefinition.setPrimary(true);
        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, className,
                new String[] { alias });
        // 注册BeanDefinition
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, beanDefinitionRegistry);

    }

    /**
     * 获取扫描的包名
     * @param annotationMetadata
     * @return
     */
    private Set<String> getBasePackages(AnnotationMetadata annotationMetadata) {
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(EnableRpcClient.class.getCanonicalName());

        Set<String> basePackages = new HashSet<>();
        // 指定包名
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        // 如果没有指定包名，则扫描注解所在类的包名
        if (basePackages.size() == 0) {
            //将带有注解的所有类放入basePackages中
            basePackages.add(ClassUtils.getPackageName(annotationMetadata.getClassName()));
        }

        return basePackages;
    }

    /**
     * 扫描路径，提供者组件的条件
     * @return
     */
    private ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                // 判断候选人的条件:必须是独立的，然后是接口
                if (beanDefinition.getMetadata().isIndependent() && beanDefinition.getMetadata().isInterface()) {
                    return true;
                }
                return false;
            }
        };
    }
}
