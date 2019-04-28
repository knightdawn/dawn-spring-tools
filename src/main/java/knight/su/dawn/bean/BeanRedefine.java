package knight.su.dawn.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * Created by sugengbin 2019/04/28
 */
public class BeanRedefine {

	/**
	 * 
	 * @param registry
	 * @param source
	 * @param target
	 */
	public static void reDefine(BeanDefinitionRegistry registry, Class<?> source, Class<?> target) {
		String[] beanNames = registry.getBeanDefinitionNames();
		if (null == beanNames || beanNames.length == 0) {
			return;
		}
		for (String beanName : beanNames) {
			BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
			String className = beanDefinition.getBeanClassName();
			if (source.getName().equals(className)) {
				beanDefinition.setBeanClassName(target.getName());
				registry.removeBeanDefinition(beanName);
				registry.registerBeanDefinition(beanName, beanDefinition);
			}
		}
	}
	
	
}
