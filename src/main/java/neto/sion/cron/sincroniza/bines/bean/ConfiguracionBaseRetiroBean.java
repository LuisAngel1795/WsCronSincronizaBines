/* Decompiler 7ms, total 87ms, lines 36 */
package neto.sion.cron.sincroniza.bines.bean;

public class ConfiguracionBaseRetiroBean {
   private String numeroSerieCajaElectronica;
   private int permiteRetiroCashBack;
   private int indicaCajaElectronica;

   public String getNumeroSerieCajaElectronica() {
      return this.numeroSerieCajaElectronica;
   }

   public void setNumeroSerieCajaElectronica(String numeroSerieCajaElectronica) {
      this.numeroSerieCajaElectronica = numeroSerieCajaElectronica;
   }

   public int getPermiteRetiroCashBack() {
      return this.permiteRetiroCashBack;
   }

   public int getIndicaCajaElectronica() {
      return this.indicaCajaElectronica;
   }

   public void setIndicaCajaElectronica(int indicaCajaElectronica) {
      this.indicaCajaElectronica = indicaCajaElectronica;
   }

   public void setPermiteRetiroCashBack(int permiteRetiroCashBack) {
      this.permiteRetiroCashBack = permiteRetiroCashBack;
   }

   public String toString() {
      return "ConfiguracionBaseRetiroBean [numeroSerieCajaElectronica=" + this.numeroSerieCajaElectronica + ", permiteRetiroCashBack=" + this.permiteRetiroCashBack + ", indicaCajaElectronica=" + this.indicaCajaElectronica + "]";
   }
}
