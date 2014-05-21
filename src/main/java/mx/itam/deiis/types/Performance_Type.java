
/* First created by JCasGen Wed May 21 14:59:51 CDT 2014 */
package mx.itam.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed May 21 14:59:51 CDT 2014
 * @generated */
public class Performance_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Performance_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Performance_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Performance(addr, Performance_Type.this);
  			   Performance_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Performance(addr, Performance_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Performance.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.Performance");
 
  /** @generated */
  final Feature casFeat_execTime;
  /** @generated */
  final int     casFeatCode_execTime;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getExecTime(int addr) {
        if (featOkTst && casFeat_execTime == null)
      jcas.throwFeatMissing("execTime", "mx.itam.deiis.types.Performance");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_execTime);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setExecTime(int addr, double v) {
        if (featOkTst && casFeat_execTime == null)
      jcas.throwFeatMissing("execTime", "mx.itam.deiis.types.Performance");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_execTime, v);}
    
  
 
  /** @generated */
  final Feature casFeat_phase;
  /** @generated */
  final int     casFeatCode_phase;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPhase(int addr) {
        if (featOkTst && casFeat_phase == null)
      jcas.throwFeatMissing("phase", "mx.itam.deiis.types.Performance");
    return ll_cas.ll_getStringValue(addr, casFeatCode_phase);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPhase(int addr, String v) {
        if (featOkTst && casFeat_phase == null)
      jcas.throwFeatMissing("phase", "mx.itam.deiis.types.Performance");
    ll_cas.ll_setStringValue(addr, casFeatCode_phase, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Performance_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_execTime = jcas.getRequiredFeatureDE(casType, "execTime", "uima.cas.Double", featOkTst);
    casFeatCode_execTime  = (null == casFeat_execTime) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_execTime).getCode();

 
    casFeat_phase = jcas.getRequiredFeatureDE(casType, "phase", "uima.cas.String", featOkTst);
    casFeatCode_phase  = (null == casFeat_phase) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_phase).getCode();

  }
}



    