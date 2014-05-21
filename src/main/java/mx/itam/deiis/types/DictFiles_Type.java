
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
public class DictFiles_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DictFiles_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DictFiles_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DictFiles(addr, DictFiles_Type.this);
  			   DictFiles_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DictFiles(addr, DictFiles_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DictFiles.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.DictFiles");
 
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
      jcas.throwFeatMissing("path", "mx.itam.deiis.types.DictFiles");
    return ll_cas.ll_getStringValue(addr, casFeatCode_path);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPath(int addr, String v) {
        if (featOkTst && casFeat_path == null)
      jcas.throwFeatMissing("path", "mx.itam.deiis.types.DictFiles");
    ll_cas.ll_setStringValue(addr, casFeatCode_path, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public DictFiles_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_path = jcas.getRequiredFeatureDE(casType, "path", "uima.cas.String", featOkTst);
    casFeatCode_path  = (null == casFeat_path) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_path).getCode();

  }
}



    