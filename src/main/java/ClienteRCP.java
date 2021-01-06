import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClienteRCP {

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl configuracion = new  XmlRpcClientConfigImpl();
        configuracion.setServerURL(new URL("http://localhost:1205"));
        XmlRpcClient cliente = new XmlRpcClient();
        cliente.setConfig(configuracion);
        Scanner leer = new Scanner(System.in);
        //Siempre usar arreglos apra guardar los valores

        int pregunta=0;
        while(pregunta != 0){
            Object[] numeros = new Object [3];
            System.out.println("ingresa el primer numero: ");
            numeros[0]= leer.nextDouble();
            System.out.println("ingresa el segundo numero: ");
            numeros[1]= leer.nextDouble();
            System.out.println("ingresa el tercer numero: ");
            numeros[2]= leer.nextDouble();


            String resultado = (String)cliente.execute("Metodos.operaciones",numeros);
            System.out.println(resultado);

            System.out.println("Desea volver a ingresar tros tres números? 1 = si / 0 = no");
            pregunta = leer.nextInt();
        }



    }
}
