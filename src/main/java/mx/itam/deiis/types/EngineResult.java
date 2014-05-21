

/* First created by JCasGen Wed May 21 04:24:52 CDT 2014 */
package mx.itam.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** This annotations stores the result of an engine
 * Updated by JCasGen Wed May 21 04:24:52 CDT 2014
 * XML source: E:/MCC/Semester 4/IIS/Workspace/VPProjectZal/src/main/resources/videoProc_typeSystem.xml
 * @generated */
public class EngineResult extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(EngineResult.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected EngineResult() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public EngineResult(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public EngineResult(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public EngineResult(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: file

  /** getter for file - gets The file where the result should be stored
   * @generated
   * @return value of the feature 
   */
  public String getFile() {
    if (EngineResult_Type.featOkTst && ((EngineResult_Type)jcasType).casFeat_file == null)
      jcasType.jcas.throwFeatMissing("file", "mx.itam.deiis.types.EngineResult");
    return jcasType.ll_cas.ll_getStringValue(addr, ((EngineResult_Type)jcasType).casFeatCode_file);}
    
  /** setter for file - sets The file where the result should be stored 
   * @generated
   * @param v value to set into the feature 
   */
  public void setFile(String v) {
    if (EngineResult_Type.featOkTst && ((EngineResult_Type)jcasType).casFeat_file == null)
      jcasType.jcas.throwFeatMissing("file", "mx.itam.deiis.types.EngineResult");
    jcasType.ll_cas.ll_setStringValue(addr, ((EngineResult_Type)jcasType).casFeatCode_file, v);}    
  }

    