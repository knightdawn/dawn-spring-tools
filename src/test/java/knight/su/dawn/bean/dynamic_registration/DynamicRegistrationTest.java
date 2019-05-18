package knight.su.dawn.bean.dynamic_registration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 动态注册 bean demo
 * Date: 2019年5月9日<br/>
 * 
 * @author sugengbin
 */
@Component
public class DynamicRegistrationTest implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("postProcessBeanFactory...");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("postProcessBeanDefinitionRegistry...");

		// 创建BeanDefinitionBuilder
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(RegistrationTest.class);
		// 设置属性值
		builder.addPropertyValue("name", "sugengbin");
		// 设置可通过@Autowire注解引用
		builder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
		// 注册到BeanDefinitionRegistry
		registry.registerBeanDefinition("registrationTest", builder.getBeanDefinition());
	}

}
