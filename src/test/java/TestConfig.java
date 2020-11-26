import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.domain.repo"})  //.jpa"})  // Repositories path - репозитории
@EntityScan(basePackages = {"com.domain.models"})  // {"ru.education.entity"})  // Entityes path - сущности
public class TestConfig {
}
