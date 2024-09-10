package control;

import control.objetosconsulta.OperadorConsulta;
import control.objetosconsulta.VendedorConsulta;
import control.objetosconsulta.VentasRecarga;
import control.objetosconsulta.VentasRecargaConsulta;
import control.objetosconsulta.VentasTotalesOperador;
import control.objetosconsulta.VentasTotalesVendedor;
import integracion.IntegradorRecargas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "index_control")
//@RequestScoped
@SessionScoped
public class IndexControl {

    private List<SelectItem> operadores;
    private Integer idOperadorSeleccionado;
    private List<SelectItem> vendedores;
    private Integer idVendedorSeleccionado;
    private Integer valorRecarga;
    
    private VentasRecarga datosRecarga = new VentasRecarga();
    private VentasRecargaConsulta datosRecargaGuardada = new VentasRecargaConsulta();
    private List<OperadorConsulta> listaoperadores;
    private List<VendedorConsulta> listavendedores;
    private List<VentasRecargaConsulta> listaventas;
    private List<VentasTotalesOperador> listaventastotalesop;
    private List<VentasTotalesVendedor> listaventastotalesve;
    
    public Integer getValorRecarga() {
        return valorRecarga;
    }

    public void setValorRecarga(Integer valorRecarga) {
        this.valorRecarga = valorRecarga;
    }

    public VentasRecargaConsulta getDatosRecargaGuardada() {
        return datosRecargaGuardada;
    }

    public void setDatosRecargaGuardada(VentasRecargaConsulta datosRecargaGuardada) {
        this.datosRecargaGuardada = datosRecargaGuardada;
    }


    public Integer getIdOperadorSeleccionado() {
        return idOperadorSeleccionado;
    }

    public void setIdOperadorSeleccionado(Integer idOperadorSeleccionado) {
        this.idOperadorSeleccionado = idOperadorSeleccionado;
    }

    public Integer getIdVendedorSeleccionado() {
        return idVendedorSeleccionado;
    }

    public void setIdVendedorSeleccionado(Integer idVendedorSeleccionado) {
        this.idVendedorSeleccionado = idVendedorSeleccionado;
    }

    public VentasRecarga getDatosRecarga() {
        
//        datosRecarga=new VentasRecarga();
//        datosRecarga.setOperadorIdoperador(idOperadorSeleccionado);
//        datosRecarga.setVendedorIdvendedor(idVendedorSeleccionado);
//        datosRecarga.setValorRecarga(valorRecarga);
//        
//        System.out.println("Recarga Operador 0: " + datosRecarga.getOperadorIdoperador());
//        System.out.println("Recarga Vendedor 0: " + datosRecarga.getVendedorIdvendedor());
//        System.out.println("Recarga Valor    0: " + datosRecarga.getValorRecarga());

        return datosRecarga;
    }

    public void setDatosRecarga(VentasRecarga datosRecarga) {
        this.datosRecarga = datosRecarga;
    }

    public List<SelectItem> getOperadores() {
        operadores=new ArrayList();
        List<OperadorConsulta> listaoperadoresconsulta = new IntegradorRecargas().listarOperadoresConBackend();
        for (OperadorConsulta operadorConsulta : listaoperadoresconsulta) {
            operadores.add(new SelectItem(operadorConsulta.getIdoperador(), operadorConsulta.getNombre()));
        }
        return operadores;
    }

    public void setOperadores(List<SelectItem> operadores) {
        this.operadores = operadores;
    }

    public List<SelectItem> getVendedores() {
        vendedores=new ArrayList();
        List<VendedorConsulta> listavendedoresconsulta = new IntegradorRecargas().listarVendedoresConBackend();
        for (VendedorConsulta vendedorConsulta : listavendedoresconsulta) {
            vendedores.add(new SelectItem(vendedorConsulta.getIdvendedor(), vendedorConsulta.getNombre()));
        }

        return vendedores;
    }

    public void setVendedores(List<SelectItem> vendedores) {
        this.vendedores = vendedores;
    }

    public List<OperadorConsulta> getListaoperadores() {

        List<OperadorConsulta> listaoperadoresconsulta = new IntegradorRecargas().listarOperadoresConBackend();

        return listaoperadores;
    }

    public void setListaoperadores(List<OperadorConsulta> listaoperadores) {
        this.listaoperadores = listaoperadores;
    }

    public List<VendedorConsulta> getListavendedores() {

        List<VendedorConsulta> listavendedoresconsulta = new IntegradorRecargas().listarVendedoresConBackend();
        return listavendedores;
    }

    public void setListavendedores(List<VendedorConsulta> listavendedores) {
        this.listavendedores = listavendedores;
    }

    public List<VentasRecargaConsulta> getListaventas() {

        List<VentasRecargaConsulta> listaventas = new IntegradorRecargas().listarVentasConBackend();
        return listaventas;
    }

    public void setListaventas(List<VentasRecargaConsulta> listaventas) {
        this.listaventas = listaventas;
    }

    public List<VentasTotalesOperador> getListaventastotalesop() {
        return listaventastotalesop;
    }

    public void setListaventastotalesop(List<VentasTotalesOperador> listaventastotalesop) {
        this.listaventastotalesop = listaventastotalesop;
    }

    public List<VentasTotalesVendedor> getListaventastotalesve() {
        return listaventastotalesve;
    }

    public void setListaventastotalesve(List<VentasTotalesVendedor> listaventastotalesve) {
        this.listaventastotalesve = listaventastotalesve;
    }

    public void eventoRegistrarRecarga() {

        VentasRecargaConsulta resultado = new IntegradorRecargas().registrarRecargaConBackend(datosRecarga);

        System.out.println("respuesta: ");
        System.out.println(resultado.getIdventas_recarga());
        System.out.println(resultado.getValor_recarga());

    }
    public void eventoListarVentasTotalOperador() {
        
        listaventastotalesop = new IntegradorRecargas().ListarTotalVentasOperadorConBackend();
        
    }
    public void eventoListarVentasTotalVendedor() {
        
        listaventastotalesve = new IntegradorRecargas().ListarTotalVentasVendedorConBackend();
        
    }
}
