import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Mangler on 8/22/2016.
 */
public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;

}
