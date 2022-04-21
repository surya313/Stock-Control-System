//package project.springboot;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.authorizeRequests()
//			.antMatchers("/css/**").permitAll()
//			.antMatchers("/addproduct").permitAll()
//			.antMatchers("/editproduct").permitAll()
//			.antMatchers("/authenticate/{userName}/{password}").permitAll()
//			.antMatchers("/barcode").permitAll()
//			.antMatchers("/listproducts").permitAll()
//			.antMatchers("/addorders").permitAll()
//			.antMatchers("/ordersreport").permitAll()
//			.antMatchers("/barcodeGenerate/{z}/{a}/{l}").permitAll()
//			.antMatchers("/productsreportToShelve").permitAll()
//			.antMatchers("/productsreportToPick").permitAll()
//			.antMatchers("/shelveproduct").permitAll()
//			.antMatchers("/ordersbarcodeGenerate/{orderId}").permitAll()
//			.antMatchers("/picking").permitAll()
//			.antMatchers("/shortItems").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic()
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.permitAll()
//			.and()
//			.csrf().disable();
//	}
//	
//	
//	
//
//}
