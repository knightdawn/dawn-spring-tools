package knight.su.dawn.bean.dynamic_registration;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/** 
 *
 * Date:     2019年5月9日<br/> 
 * @author   sugengbin 
 */
@ContextConfiguration(locations = { "classpath*:bean.xml" })
public class RegistrationMainTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private RegistrationTest test;
	
	@Test
	public void test() {
		System.out.println(test.getName());
//		postProcessBeanDefinitionRegistry...
//		postProcessBeanFactory...
//		sugengbin
	} 
}
