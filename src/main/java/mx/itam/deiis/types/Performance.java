

/* First created by JCasGen Wed May 21 04:24:52 CDT 2014 */
package mx.itam.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed May 21 04:24:52 CDT 2014
 * XML source: E:/MCC/Semester 4/IIS/Workspace/VPProjectZal/src/main/resources/videoProc_typeSystem.xml
 * @generated */
public class Performance extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Performance.class);
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
  protected Performance() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Performance(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Performance(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Performance(JCas jcas, int begin, int end) {
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
  //* Feature: execTime

  /** getter for execTime - gets 
   * @generated
   * @return value of the feature 
   */
  public double getExecTime() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_execTime == null)
      jcasType.jcas.throwFeatMissing("execTime", "mx.itam.deiis.types.Performance");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_execTime);}
    
  /** setter for execTime - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setExecTime(double v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_execTime == null)
      jcasType.jcas.throwFeatMissing("execTime", "mx.itam.deiis.types.Performance");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Performance_Type)jcasType).casFeatCode_execTime, v);}    
   
    
  //*--------------*
  //* Feature: phase

  /** getter for phase - gets 
   * @generated
   * @return value of the feature 
   */
  public String getPhase() {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_phase == null)
      jcasType.jcas.throwFeatMissing("phase", "mx.itam.deiis.types.Performance");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Performance_Type)jcasType).casFeatCode_phase);}
    
  /** setter for phase - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPhase(String v) {
    if (Performance_Type.featOkTst && ((Performance_Type)jcasType).casFeat_phase == null)
      jcasType.jcas.throwFeatMissing("phase", "mx.itam.deiis.types.Performance");
    jcasType.ll_cas.ll_setStringValue(addr, ((Performance_Type)jcasType).casFeatCode_phase, v);}    
  }

    