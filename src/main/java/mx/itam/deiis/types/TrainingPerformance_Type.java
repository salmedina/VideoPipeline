
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
public class TrainingPerformance_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TrainingPerformance_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TrainingPerformance_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TrainingPerformance(addr, TrainingPerformance_Type.this);
  			   TrainingPerformance_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TrainingPerformance(addr, TrainingPerformance_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TrainingPerformance.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.TrainingPerformance");
 
  /** @generated */
  final Feature casFeat_featExtract;
  /** @generated */
  final int     casFeatCode_featExtract;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFeatExtract(int addr) {
        if (featOkTst && casFeat_featExtract == null)
      jcas.throwFeatMissing("featExtract", "mx.itam.deiis.types.TrainingPerformance");
    return ll_cas.ll_getRefValue(addr, casFeatCode_featExtract);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFeatExtract(int addr, int v) {
        if (featOkTst && casFeat_featExtract == null)
      jcas.throwFeatMissing("featExtract", "mx.itam.deiis.types.TrainingPerformance");
    ll_cas.ll_setRefValue(addr, casFeatCode_featExtract, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dictGen;
  /** @generated */
  final int     casFeatCode_dictGen;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getDictGen(int addr) {
        if (featOkTst && casFeat_dictGen == null)
      jcas.throwFeatMissing("dictGen", "mx.itam.deiis.types.TrainingPerformance");
    return ll_cas.ll_getRefValue(addr, casFeatCode_dictGen);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDictGen(int addr, int v) {
        if (featOkTst && casFeat_dictGen == null)
      jcas.throwFeatMissing("dictGen", "mx.itam.deiis.types.TrainingPerformance");
    ll_cas.ll_setRefValue(addr, casFeatCode_dictGen, v);}
    
  
 
  /** @generated */
  final Feature casFeat_vwTranslation;
  /** @generated */
  final int     casFeatCode_vwTranslation;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getVwTranslation(int addr) {
        if (featOkTst && casFeat_vwTranslation == null)
      jcas.throwFeatMissing("vwTranslation", "mx.itam.deiis.types.TrainingPerformance");
    return ll_cas.ll_getRefValue(addr, casFeatCode_vwTranslation);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setVwTranslation(int addr, int v) {
        if (featOkTst && casFeat_vwTranslation == null)
      jcas.throwFeatMissing("vwTranslation", "mx.itam.deiis.types.TrainingPerformance");
    ll_cas.ll_setRefValue(addr, casFeatCode_vwTranslation, v);}
    
  
 
  /** @generated */
  final Feature casFeat_experiment;
  /** @generated */
  final int     casFeatCode_experiment;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getExperiment(int addr) {
        if (featOkTst && casFeat_experiment == null)
      jcas.throwFeatMissing("experiment", "mx.itam.deiis.types.TrainingPerformance");
    return ll_cas.ll_getRefValue(addr, casFeatCode_experiment);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setExperiment(int addr, int v) {
        if (featOkTst && casFeat_experiment == null)
      jcas.throwFeatMissing("experiment", "mx.itam.deiis.types.TrainingPerformance");
    ll_cas.ll_setRefValue(addr, casFeatCode_experiment, v);}
    
  
 
  /** @generated */
  final Feature casFeat_indexGen;
  /** @generated */
  final int     casFeatCode_indexGen;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIndexGen(int addr) {
        if (featOkTst && casFeat_indexGen == null)
      jcas.throwFeatMissing("indexGen", "mx.itam.deiis.types.TrainingPerformance");
    return ll_cas.ll_getRefValue(addr, casFeatCode_indexGen);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIndexGen(int addr, int v) {
        if (featOkTst && casFeat_indexGen == null)
      jcas.throwFeatMissing("indexGen", "mx.itam.deiis.types.TrainingPerformance");
    ll_cas.ll_setRefValue(addr, casFeatCode_indexGen, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TrainingPerformance_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_featExtract = jcas.getRequiredFeatureDE(casType, "featExtract", "mx.itam.deiis.types.Performance", featOkTst);
    casFeatCode_featExtract  = (null == casFeat_featExtract) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_featExtract).getCode();

 
    casFeat_dictGen = jcas.getRequiredFeatureDE(casType, "dictGen", "mx.itam.deiis.types.Performance", featOkTst);
    casFeatCode_dictGen  = (null == casFeat_dictGen) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dictGen).getCode();

 
    casFeat_vwTranslation = jcas.getRequiredFeatureDE(casType, "vwTranslation", "mx.itam.deiis.types.Performance", featOkTst);
    casFeatCode_vwTranslation  = (null == casFeat_vwTranslation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_vwTranslation).getCode();

 
    casFeat_experiment = jcas.getRequiredFeatureDE(casType, "experiment", "mx.itam.deiis.types.Experiment", featOkTst);
    casFeatCode_experiment  = (null == casFeat_experiment) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_experiment).getCode();

 
    casFeat_indexGen = jcas.getRequiredFeatureDE(casType, "indexGen", "mx.itam.deiis.types.Performance", featOkTst);
    casFeatCode_indexGen  = (null == casFeat_indexGen) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_indexGen).getCode();

  }
}



    