package web.mvc.hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import web.mvc.hibernate.model.User;


@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer { //WebMvcConfigurer-используем этот интерфейс для использования нужного
    // нам шаблонизатора Таймлиф используя его метод configureViewResolvers


   private final ApplicationContext applicationContext; // добавляем контекст

   @Autowired
    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    // Создание и конфигурация объекта для разрешения шаблонов Thymeleaf, основанных на ресурсах Spring
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);// Установка контекста приложения для разрешения ресурсов
        templateResolver.setPrefix("/WEB-INF/view/");// Путь к шаблонам представления
        templateResolver.setSuffix(".html");// выбор расширения файлов шаблонов представления
        return templateResolver;// Возвращение сконфигурированного объекта шаблонного разрешителя
    }


    // Создание и конфигурация движка шаблонов Thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());// Установка шаблонного разрешителя
        templateEngine.setEnableSpringELCompiler(true);// Включение компиляции Spring Expression Language (Spring EL)
        return templateEngine;// Возвращение сконфигурированного объекта движка шаблонов
    }


    // Конфигурация резольвера представлений для Thymeleaf
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine()); // Установка движка шаблонов для резольвера
        registry.viewResolver(resolver);// Регистрация резольвера в реестре резольверов представлений
    }



}
