
/* First created by JCasGen Wed May 21 04:24:52 CDT 2014 */
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
 * Updated by JCasGen Wed May 21 04:24:52 CDT 2014
 * @generated */
public class SourceFiles_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SourceFiles_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SourceFiles_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SourceFiles(addr, SourceFiles_Type.this);
  			   SourceFiles_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SourceFiles(addr, SourceFiles_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SourceFiles.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.SourceFiles");
 
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
      jcas.throwFeatMissing("path", "mx.itam.deiis.types.SourceFiles");
    return ll_cas.ll_getStringValue(addr, casFeatCode_path);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPath(int addr, String v) {
        if (featOkTst && casFeat_path == null)
      jcas.throwFeatMissing("path", "mx.itam.deiis.types.SourceFiles");
    ll_cas.ll_setStringValue(addr, casFeatCode_path, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ext;
  /** @generated */
  final int     casFeatCode_ext;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getExt(int addr) {
        if (featOkTst && casFeat_ext == null)
      jcas.throwFeatMissing("ext", "mx.itam.deiis.types.SourceFiles");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ext);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setExt(int addr, String v) {
        if (featOkTst && casFeat_ext == null)
      jcas.throwFeatMissing("ext", "mx.itam.deiis.types.SourceFiles");
    ll_cas.ll_setStringValue(addr, casFeatCode_ext, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public SourceFiles_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_path = jcas.getRequiredFeatureDE(casType, "path", "uima.cas.String", featOkTst);
    casFeatCode_path  = (null == casFeat_path) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_path).getCode();

 
    casFeat_ext = jcas.getRequiredFeatureDE(casType, "ext", "uima.cas.String", featOkTst);
    casFeatCode_ext  = (null == casFeat_ext) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ext).getCode();

  }
}



    