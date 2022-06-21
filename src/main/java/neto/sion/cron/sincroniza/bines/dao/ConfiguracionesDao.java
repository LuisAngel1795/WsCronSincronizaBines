/* Decompiler 129ms, total 241ms, lines 216 */
package neto.sion.cron.sincroniza.bines.dao;

import Com.Elektra.Definition.Config.ConfigSION;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import neto.sion.cron.sincroniza.bines.bean.BancoBeanCO;
import neto.sion.cron.sincroniza.bines.bean.BinBeanCo;
import neto.sion.cron.sincroniza.bines.bean.ConfiguracionBaseRetiroBean;
import neto.sion.cron.sincroniza.bines.bean.NivelComisionBean;
import neto.sion.cron.sincroniza.bines.bean.PeticionTienda;
import neto.sion.cron.sincroniza.bines.bean.RespuestaBancoBeanCO;
import neto.sion.cron.sincroniza.bines.bean.RespuestaBinBeanCo;
import neto.sion.cron.sincroniza.bines.bean.RespuestaNivelesComisionRetiro;
import neto.sion.genericos.log.Logeo;
import neto.sion.genericos.sql.Conexion;
import org.apache.axis2.AxisFault;

public class ConfiguracionesDao extends Conexion {
   public ConfiguracionesDao() {
      super(ConfigSION.obtenerParametro("dataSource"));
   }

   public RespuestaBancoBeanCO respuestaBancoCOBean(PeticionTienda _peticion) throws AxisFault {
      RespuestaBancoBeanCO respuesta = new RespuestaBancoBeanCO();
      Connection connection = null;
      CallableStatement cs = null;
      ResultSet bancos = null;
      String sql = null;

      try {
         sql = ConfigSION.obtenerParametro("VENTA.PACASHOUT.CONSULTA.BANCOS");
         connection = this.obtenerConexion();
         Logeo.log("Peticion Tienda " + _peticion);
         Logeo.log("Peticion Tienda to Str " + _peticion.toString());
         cs = connection.prepareCall(sql);
         cs.setInt(1, _peticion.getPais());
         cs.setLong(2, (long)_peticion.getTienda());
         cs.registerOutParameter(3, -10);
         cs.registerOutParameter(4, 4);
         cs.registerOutParameter(5, 12);
         cs.execute();
         Logeo.log("Resp code  " + cs.getInt(4));
         Logeo.log("Resp Desc  " + cs.getString(5));
         long respuestaConsulta = (long)cs.getInt(4);
         if (respuestaConsulta != 0L) {
            Logeo.log("Error al consultar bancos:" + cs.getString(5));
            RespuestaBancoBeanCO var16 = respuesta;
            return var16;
         } else {
            bancos = (ResultSet)cs.getObject(3);
            ArrayList listaBancos = new ArrayList();

            while(bancos.next()) {
               BancoBeanCO bancoBean = new BancoBeanCO();
               bancoBean.setFiBancoId(bancos.getInt(1));
               bancoBean.setFcNombre(bancos.getString(2));
               bancoBean.setFcDescripcion(bancos.getString(3));
               bancoBean.setFiEstatus(bancos.getInt(4));
               bancoBean.setComision(bancos.getFloat(5));
               bancoBean.setImagenBanco(bancos.getString(6));
               bancoBean.setLimiteRetiro(bancos.getInt(7));
               listaBancos.add(bancoBean);
            }

            BancoBeanCO[] arregloBancos = new BancoBeanCO[listaBancos.size()];
            listaBancos.toArray(arregloBancos);
            respuesta.setBancoBeans(arregloBancos);
            Logeo.log("Respuesta de la peticion del instalador de venta:" + respuesta.hashCode());
            return respuesta;
         }
      } catch (Exception var14) {
         Logeo.logearExcepcion(var14, new String[]{sql, ""});
         throw new AxisFault(var14.getLocalizedMessage());
      } finally {
         Conexion.cerrarStatement(cs);
         Conexion.cerrarResultSet(bancos);
         Conexion.cerrarConexion(connection);
      }
   }

   public RespuestaBinBeanCo respuestaBinCoBean() throws AxisFault {
      RespuestaBinBeanCo respuesta = new RespuestaBinBeanCo();
      Connection connection = null;
      CallableStatement cs = null;
      ResultSet bines = null;
      String sql = null;

      try {
         sql = ConfigSION.obtenerParametro("VENTA.PACASHOUT.CONSULTA.BINES");
         connection = this.obtenerConexion();
         cs = connection.prepareCall(sql);
         cs.registerOutParameter(1, -10);
         cs.execute();
         bines = (ResultSet)cs.getObject(1);
         ArrayList listaBines = new ArrayList();

         while(bines.next()) {
            BinBeanCo binBean = new BinBeanCo();
            binBean.setFiBinesId(bines.getLong(1));
            binBean.setFiTipoTarjetaId(bines.getInt(2));
            binBean.setFiOrigenId(bines.getInt(3));
            binBean.setFiBancoId(bines.getInt(4));
            binBean.setIndicaRetiroCO(bines.getInt(5));
            listaBines.add(binBean);
         }

         BinBeanCo[] arregloBines = new BinBeanCo[listaBines.size()];
         listaBines.toArray(arregloBines);
         respuesta.setBinBean(arregloBines);
         Logeo.log("Respuesta de la peticion del instalador de venta:" + respuesta.hashCode());
         return respuesta;
      } catch (Exception var11) {
         Logeo.logearExcepcion(var11, new String[]{sql, ""});
         throw new AxisFault(var11.getLocalizedMessage());
      } finally {
         Conexion.cerrarStatement(cs);
         Conexion.cerrarResultSet(bines);
         Conexion.cerrarConexion(connection);
      }
   }

   public ConfiguracionBaseRetiroBean obtenerIpAncladaEstatusRetiro(PeticionTienda _solicitud) {
      ConfiguracionBaseRetiroBean respuesta = new ConfiguracionBaseRetiroBean();
      Connection conn = null;
      CallableStatement cstmt = null;
      String sql = null;

      try {
         sql = ConfigSION.obtenerParametro("VENTA.PACASHOUT.CONSULTA.SERIE.ANCLADA");
         conn = this.obtenerConexion();
         cstmt = conn.prepareCall(sql);
         cstmt.setInt(1, _solicitud.getPais());
         cstmt.setInt(2, _solicitud.getTienda());
         cstmt.registerOutParameter(3, 12);
         cstmt.registerOutParameter(4, 4);
         cstmt.registerOutParameter(5, 4);
         cstmt.registerOutParameter(6, 2);
         cstmt.registerOutParameter(7, 12);
         Logeo.log("Ejecutando consulta... " + cstmt.toString());
         cstmt.execute();
         Logeo.log("CODIGO-- " + cstmt.getInt(6));
         Logeo.log("DESC-- " + cstmt.getString(7));
         if (cstmt.getInt(6) == 0) {
            respuesta.setNumeroSerieCajaElectronica(cstmt.getString(3));
            respuesta.setPermiteRetiroCashBack(cstmt.getInt(4));
            respuesta.setPermiteRetiroCashBack(cstmt.getInt(5));
         }
      } catch (Exception var10) {
         Logeo.logearExcepcion(var10, new String[]{sql, cstmt.toString()});
         var10.printStackTrace();
      } finally {
         Conexion.cerrarRecursos(conn, cstmt, (ResultSet)null);
      }

      return respuesta;
   }

   public RespuestaNivelesComisionRetiro consultaNivelesComisionesRetiro(PeticionTienda _peticion) {
      RespuestaNivelesComisionRetiro respuesta = new RespuestaNivelesComisionRetiro();
      Connection connection = null;
      CallableStatement cs = null;
      ResultSet comisiones = null;
      String sql = null;

      RespuestaNivelesComisionRetiro var7;
      try {
         connection = this.obtenerConexion();
         sql = ConfigSION.obtenerParametro("VENTA.PACASHOUT.CONSULTA.NIVELES_COMISION");
         cs = connection.prepareCall(sql);
         cs.setInt(1, _peticion.getPais());
         cs.setInt(2, _peticion.getTienda());
         cs.registerOutParameter(3, -10);
         cs.registerOutParameter(4, 4);
         cs.registerOutParameter(5, 12);
         cs.execute();
         if (cs.getInt(4) == 0) {
            comisiones = (ResultSet)cs.getObject(3);
            ArrayList listaNiveles = new ArrayList();

            while(comisiones.next()) {
               NivelComisionBean comision = new NivelComisionBean();
               comision.setLimiteId(comisiones.getInt(1));
               comision.setComision(comisiones.getFloat(2));
               comision.setImporteMinVenta(comisiones.getFloat(3));
               comision.setImporteMaxVenta(comisiones.getFloat(4));
               comision.setEstatus(comisiones.getInt(5));
               listaNiveles.add(comision);
            }

            if (listaNiveles.size() > 0) {
               NivelComisionBean[] arrNiveles = new NivelComisionBean[listaNiveles.size()];
               listaNiveles.toArray(arrNiveles);
               respuesta.setNivelesComisiones(arrNiveles);
            }

            return respuesta;
         }

         var7 = respuesta;
      } catch (SQLException var13) {
         Logeo.logearExcepcion(var13, new String[]{sql, cs.toString()});
         return respuesta;
      } catch (Exception var14) {
         Logeo.logearExcepcion(var14, new String[]{sql, cs.toString()});
         return respuesta;
      } finally {
         Conexion.cerrarRecursos(connection, cs, (ResultSet)null);
      }

      return var7;
   }
}
