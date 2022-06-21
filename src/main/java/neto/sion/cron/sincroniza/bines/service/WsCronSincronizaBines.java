/* Decompiler 22ms, total 180ms, lines 40 */
package neto.sion.cron.sincroniza.bines.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import neto.sion.cron.sincroniza.bines.bean.ConfiguracionBaseRetiroBean;
import neto.sion.cron.sincroniza.bines.bean.PeticionTienda;
import neto.sion.cron.sincroniza.bines.bean.RespuestaBancoBeanCO;
import neto.sion.cron.sincroniza.bines.bean.RespuestaBinBeanCo;
import neto.sion.cron.sincroniza.bines.bean.RespuestaNivelesComisionRetiro;
import neto.sion.cron.sincroniza.bines.controlador.ConfiguracionesController;
import neto.sion.genericos.log.Logeo;
import org.apache.axis2.AxisFault;

import neto.util.Interceptor;
import javax.interceptor.Interceptors;

@WebService
@Interceptors({Interceptor.class})
public class WsCronSincronizaBines {
   private ConfiguracionesController configuracionesController = new ConfiguracionesController();

   @WebMethod
   public RespuestaBancoBeanCO obtenerBancosCO(@WebParam(name = "_peticion") PeticionTienda _peticion) throws AxisFault {
      Logeo.log("Cron Sincroniza Bines obtenerBancosCO " + _peticion.toString());
      return this.configuracionesController.obtenerBancosCO(_peticion);
   }

   @WebMethod
   public RespuestaBinBeanCo obtenerBinCoBean() throws AxisFault {
      return this.configuracionesController.respuestaBinCoBean();
   }

   @WebMethod
   public ConfiguracionBaseRetiroBean obtenerIpAncladaEstatusRetiro(@WebParam(name = "_solicitud") PeticionTienda _solicitud) throws AxisFault {
      return this.configuracionesController.obtenerIpAncladaEstatusRetiro(_solicitud);
   }

   @WebMethod
   public RespuestaNivelesComisionRetiro consultaNivelesComisionesRetiro(@WebParam(name = "_solicitud") PeticionTienda _peticion) throws AxisFault {
      return this.configuracionesController.consultaNivelesComisionesRetiro(_peticion);
   }
}
