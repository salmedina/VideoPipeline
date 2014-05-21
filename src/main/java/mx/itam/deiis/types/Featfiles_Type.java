
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
public class FeatFiles_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (FeatFiles_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = FeatFiles_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new FeatFiles(addr, FeatFiles_Type.this);
  			   FeatFiles_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new FeatFiles(addr, FeatFiles_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = FeatFiles.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.FeatFiles");
 
  /** @generated */
  final Feature casFeat_featType;
  /** @generated */
  final int     casFeatCode_featType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFeatType(int addr) {
        if (featOkTst && casFeat_featType == null)
      jcas.throwFeatMissing("featType", "mx.itam.deiis.types.FeatFiles");
    return ll_cas.ll_getStringValue(addr, casFeatCode_featType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFeatType(int addr, String v) {
        if (featOkTst && casFeat_featType == null)
      jcas.throwFeatMissing("featType", "mx.itam.deiis.types.FeatFiles");
    ll_cas.ll_setStringValue(addr, casFeatCode_featType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_path;
  /** @generated */
  final int     casFeatCode_path;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPath(int addr) {
        if (featOkTst && casFeat_path == null)
      jcas.throwFeatMissing("path", "mx.itam.deiis.types.FeatFiles");
    return ll_cas.ll_getStringValue(addr, casFeatCode_path);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPath(int addr, String v) {
        if (featOkTst && casFeat_path == null)
      jcas.throwFeatMissing("path", "mx.itam.deiis.types.FeatFiles");
    ll_cas.ll_setStringValue(addr, casFeatCode_path, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public FeatFiles_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_featType = jcas.getRequiredFeatureDE(casType, "featType", "uima.cas.String", featOkTst);
    casFeatCode_featType  = (null == casFeat_featType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_featType).getCode();

 
    casFeat_path = jcas.getRequiredFeatureDE(casType, "path", "uima.cas.String", featOkTst);
    casFeatCode_path  = (null == casFeat_path) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_path).getCode();

  }
}



    