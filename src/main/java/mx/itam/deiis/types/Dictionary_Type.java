
/* First created by JCasGen Tue May 20 19:35:36 CDT 2014 */
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
 * Updated by JCasGen Tue May 20 19:35:36 CDT 2014
 * @generated */
public class Dictionary_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Dictionary_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Dictionary_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Dictionary(addr, Dictionary_Type.this);
  			   Dictionary_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Dictionary(addr, Dictionary_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Dictionary.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.Dictionary");
 
  /** @generated */
  final Feature casFeat_k;
  /** @generated */
  final int     casFeatCode_k;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getK(int addr) {
        if (featOkTst && casFeat_k == null)
      jcas.throwFeatMissing("k", "mx.itam.deiis.types.Dictionary");
    return ll_cas.ll_getIntValue(addr, casFeatCode_k);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setK(int addr, int v) {
        if (featOkTst && casFeat_k == null)
      jcas.throwFeatMissing("k", "mx.itam.deiis.types.Dictionary");
    ll_cas.ll_setIntValue(addr, casFeatCode_k, v);}
    
  
 
  /** @generated */
  final Feature casFeat_obj;
  /** @generated */
  final int     casFeatCode_obj;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getObj(int addr) {
        if (featOkTst && casFeat_obj == null)
      jcas.throwFeatMissing("obj", "mx.itam.deiis.types.Dictionary");
    return ll_cas.ll_getStringValue(addr, casFeatCode_obj);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setObj(int addr, String v) {
        if (featOkTst && casFeat_obj == null)
      jcas.throwFeatMissing("obj", "mx.itam.deiis.types.Dictionary");
    ll_cas.ll_setStringValue(addr, casFeatCode_obj, v);}
    
  
 
  /** @generated */
  final Feature casFeat_textFile;
  /** @generated */
  final int     casFeatCode_textFile;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTextFile(int addr) {
        if (featOkTst && casFeat_textFile == null)
      jcas.throwFeatMissing("textFile", "mx.itam.deiis.types.Dictionary");
    return ll_cas.ll_getStringValue(addr, casFeatCode_textFile);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTextFile(int addr, String v) {
        if (featOkTst && casFeat_textFile == null)
      jcas.throwFeatMissing("textFile", "mx.itam.deiis.types.Dictionary");
    ll_cas.ll_setStringValue(addr, casFeatCode_textFile, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Dictionary_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_k = jcas.getRequiredFeatureDE(casType, "k", "uima.cas.Integer", featOkTst);
    casFeatCode_k  = (null == casFeat_k) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_k).getCode();

 
    casFeat_obj = jcas.getRequiredFeatureDE(casType, "obj", "uima.cas.String", featOkTst);
    casFeatCode_obj  = (null == casFeat_obj) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_obj).getCode();

 
    casFeat_textFile = jcas.getRequiredFeatureDE(casType, "textFile", "uima.cas.String", featOkTst);
    casFeatCode_textFile  = (null == casFeat_textFile) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_textFile).getCode();

  }
}



    