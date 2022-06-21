/* Decompiler 2ms, total 166ms, lines 20 */
package neto.sion.cron.sincroniza.bines.bean;

import java.util.Arrays;

public class RespuestaBancoBeanCO {
   private BancoBeanCO[] bancoBeans;

   public BancoBeanCO[] getBancoBeans() {
      return this.bancoBeans;
   }

   public void setBancoBeans(BancoBeanCO[] bancoBeans) {
      this.bancoBeans = bancoBeans;
   }

   public String toString() {
      return "RespuestaBancoBean [bancoBeans=" + Arrays.toString(this.bancoBeans) + "]";
   }
}
