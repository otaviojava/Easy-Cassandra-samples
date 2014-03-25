package linguagil.cassandra.temperatura;

import java.util.Date;

import linguagil.cassandra.temperatura.model.PrevisaoTempoID;
import linguagil.cassandra.temperatura.service.PrevisaoMediaService;
import linguagil.cassandra.temperatura.service.PrevisaoService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("resource")
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
    	
    	PrevisaoService service = ctx.getBean(PrevisaoService.class);
    	PrevisaoMediaService mediaService = ctx.getBean(PrevisaoMediaService.class);
    	
    	PrevisaoTempoID id = new PrevisaoTempoID();
    	id.setCidade("Salvador");
    	id.setDia(new Date());
    	
    	service.inserir(id, 39d);
    	
    	System.out.println(service.findById(id));
    	System.out.println(mediaService.findById(id));
    	
    	
    }
}
