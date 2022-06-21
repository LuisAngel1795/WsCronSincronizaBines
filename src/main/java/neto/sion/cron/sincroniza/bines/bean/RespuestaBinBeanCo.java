/* Decompiler 1ms, total 145ms, lines 20 */
package neto.sion.cron.sincroniza.bines.bean;

import java.util.Arrays;

public class RespuestaBinBeanCo {
   private BinBeanCo[] binBean;

   public BinBeanCo[] getBinBean() {
      return this.binBean;
   }

   public void setBinBean(BinBeanCo[] binBean) {
      this.binBean = binBean;
   }

   public String toString() {
      return "RespuestaBinBeanCo [binBean=" + Arrays.toString(this.binBean) + "]";
   }
}
