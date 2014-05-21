
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

/** This annotations stores the result of an engine
 * Updated by JCasGen Wed May 21 04:24:52 CDT 2014
 * @generated */
public class EngineResult_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (EngineResult_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = EngineResult_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new EngineResult(addr, EngineResult_Type.this);
  			   EngineResult_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new EngineResult(addr, EngineResult_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = EngineResult.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("mx.itam.deiis.types.EngineResult");
 
  /** @generated */
  final Feature casFeat_file;
  /** @generated */
  final int     casFeatCode_file;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFile(int addr) {
        if (featOkTst && casFeat_file == null)
      jcas.throwFeatMissing("file", "mx.itam.deiis.types.EngineResult");
    return ll_cas.ll_getStringValue(addr, casFeatCode_file);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFile(int addr, String v) {
        if (featOkTst && casFeat_file == null)
      jcas.throwFeatMissing("file", "mx.itam.deiis.types.EngineResult");
    ll_cas.ll_setStringValue(addr, casFeatCode_file, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public EngineResult_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_file = jcas.getRequiredFeatureDE(casType, "file", "uima.cas.String", featOkTst);
    casFeatCode_file  = (null == casFeat_file) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_file).getCode();

  }
}



    