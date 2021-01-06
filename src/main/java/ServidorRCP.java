import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class ServidorRCP {

    public static void main(String[] args) throws XmlRpcException, IOException {
        System.out.println("Iniciando servidor RPC...");
        PropertyHandlerMapping mapeo = new PropertyHandlerMapping();
        mapeo.addHandler("Metodos",Metodos.class);
        // crear instancia con el servidor
        WebServer servidor = new WebServer(1205);
        // Le colocamos el mapeo a la redireccion
        servidor.getXmlRpcServer().setHandlerMapping(mapeo);
        //iniciar servidor
        servidor.start();
        System.out.println("Esperando peticion...");


    }
}
