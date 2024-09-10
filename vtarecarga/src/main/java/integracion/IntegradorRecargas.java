
package integracion;

import control.objetosconsulta.OperadorConsulta;
import control.objetosconsulta.VendedorConsulta;
import control.objetosconsulta.VentasRecarga;
import control.objetosconsulta.VentasRecargaConsulta;
import control.objetosconsulta.VentasTotalesOperador;
import control.objetosconsulta.VentasTotalesVendedor;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class IntegradorRecargas extends BaseIntegracion{
    
    public VentasRecargaConsulta registrarRecargaConBackend(VentasRecarga datosRecarga){
    
        System.out.println("Recarga Operador 1: " + datosRecarga.getOperadorIdoperador());
        System.out.println("Recarga Vendedor 1: " + datosRecarga.getVendedorIdvendedor());
        System.out.println("Recarga Valor    1: " + datosRecarga.getValorRecarga());

        VentasRecargaConsulta resultado = cliente.target("http://localhost:8091/ventas/crearventa")
                    .request()
                    .post(Entity.entity(datosRecarga, MediaType.APPLICATION_JSON_TYPE), VentasRecargaConsulta.class);
        return resultado;
        
    }
    
    public List<OperadorConsulta> listarOperadoresConBackend(){
    
        
        List<OperadorConsulta> resultado = null ;
                
        resultado = cliente.target("http://localhost:8091/ventas/veroperadores").request().get(new GenericType<List<OperadorConsulta>>() {
        });
        
        int cuenta=1;
        for (OperadorConsulta loperador : resultado) {
            
            System.out.println("Operador "+ cuenta + " " + loperador.getNombre());
            cuenta+=1;
        }
        
        return resultado;
        
    }
    
    public List<VendedorConsulta> listarVendedoresConBackend(){
    
        List<VendedorConsulta> resultado = cliente.target("http://localhost:8091/ventas/vervendedores").request().get(new GenericType<List<VendedorConsulta>>() {
        });
        int cuenta=1;
        for (VendedorConsulta lvendedor : resultado) {
            
            System.out.println("Vendedor "+ cuenta + " " + lvendedor.getNombre());
            cuenta+=1;
        }
        
        return resultado;
        
    }
    
    public List<VentasRecargaConsulta> listarVentasConBackend(){
        
        List<VentasRecargaConsulta> resultado = cliente.target("http://localhost:8091/ventas/verventas").request().get(new GenericType<List<VentasRecargaConsulta>>() {
        });

        return resultado;
        
    }

    public List<VentasTotalesOperador> ListarTotalVentasOperadorConBackend() {
        
        List<VentasTotalesOperador> resultado = cliente.target("http://localhost:8091/ventas/ventastotaloperador").request().get(new GenericType<List<VentasTotalesOperador>>() {
        });

        return resultado;
        
    }
    
    public List<VentasTotalesVendedor> ListarTotalVentasVendedorConBackend() {
        
        List<VentasTotalesVendedor> resultado = cliente.target("http://localhost:8091/ventas/ventastotalvendedor").request().get(new GenericType<List<VentasTotalesVendedor>>() {
        });

        return resultado;
        
    }
    
}
