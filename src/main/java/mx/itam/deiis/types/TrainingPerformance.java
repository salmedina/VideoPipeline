

/* First created by JCasGen Tue May 20 19:35:36 CDT 2014 */
package mx.itam.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue May 20 19:35:36 CDT 2014
 * XML source: E:/MCC/Semester 4/IIS/Workspace/VPProject/src/main/resources/videoProc_typeSystem.xml
 * @generated */
public class TrainingPerformance extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TrainingPerformance.class);
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
  protected TrainingPerformance() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TrainingPerformance(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TrainingPerformance(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TrainingPerformance(JCas jcas, int begin, int end) {
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
  //* Feature: featExtract

  /** getter for featExtract - gets 
   * @generated
   * @return value of the feature 
   */
  public Performance getFeatExtract() {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_featExtract == null)
      jcasType.jcas.throwFeatMissing("featExtract", "mx.itam.deiis.types.TrainingPerformance");
    return (Performance)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_featExtract)));}
    
  /** setter for featExtract - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFeatExtract(Performance v) {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_featExtract == null)
      jcasType.jcas.throwFeatMissing("featExtract", "mx.itam.deiis.types.TrainingPerformance");
    jcasType.ll_cas.ll_setRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_featExtract, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: dictGen

  /** getter for dictGen - gets 
   * @generated
   * @return value of the feature 
   */
  public Performance getDictGen() {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_dictGen == null)
      jcasType.jcas.throwFeatMissing("dictGen", "mx.itam.deiis.types.TrainingPerformance");
    return (Performance)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_dictGen)));}
    
  /** setter for dictGen - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDictGen(Performance v) {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_dictGen == null)
      jcasType.jcas.throwFeatMissing("dictGen", "mx.itam.deiis.types.TrainingPerformance");
    jcasType.ll_cas.ll_setRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_dictGen, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: vwTranslation

  /** getter for vwTranslation - gets 
   * @generated
   * @return value of the feature 
   */
  public Performance getVwTranslation() {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_vwTranslation == null)
      jcasType.jcas.throwFeatMissing("vwTranslation", "mx.itam.deiis.types.TrainingPerformance");
    return (Performance)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_vwTranslation)));}
    
  /** setter for vwTranslation - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setVwTranslation(Performance v) {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_vwTranslation == null)
      jcasType.jcas.throwFeatMissing("vwTranslation", "mx.itam.deiis.types.TrainingPerformance");
    jcasType.ll_cas.ll_setRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_vwTranslation, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: experiment

  /** getter for experiment - gets 
   * @generated
   * @return value of the feature 
   */
  public Experiment getExperiment() {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_experiment == null)
      jcasType.jcas.throwFeatMissing("experiment", "mx.itam.deiis.types.TrainingPerformance");
    return (Experiment)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_experiment)));}
    
  /** setter for experiment - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setExperiment(Experiment v) {
    if (TrainingPerformance_Type.featOkTst && ((TrainingPerformance_Type)jcasType).casFeat_experiment == null)
      jcasType.jcas.throwFeatMissing("experiment", "mx.itam.deiis.types.TrainingPerformance");
    jcasType.ll_cas.ll_setRefValue(addr, ((TrainingPerformance_Type)jcasType).casFeatCode_experiment, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    