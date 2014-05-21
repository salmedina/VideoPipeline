

/* First created by JCasGen Tue May 20 19:35:36 CDT 2014 */
package mx.itam.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed May 21 03:15:16 CDT 2014
 * XML source: /Users/IBAGNOG/Documents/workspace/video-pipeline-zal/src/main/resources/videoProc_typeSystem.xml
 * @generated */
public class Dictionary extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Dictionary.class);
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
  protected Dictionary() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Dictionary(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Dictionary(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Dictionary(JCas jcas, int begin, int end) {
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
  //* Feature: k

  /** getter for k - gets 
   * @generated
   * @return value of the feature 
   */
  public int getK() {
    if (Dictionary_Type.featOkTst && ((Dictionary_Type)jcasType).casFeat_k == null)
      jcasType.jcas.throwFeatMissing("k", "mx.itam.deiis.types.Dictionary");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Dictionary_Type)jcasType).casFeatCode_k);}
    
  /** setter for k - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setK(int v) {
    if (Dictionary_Type.featOkTst && ((Dictionary_Type)jcasType).casFeat_k == null)
      jcasType.jcas.throwFeatMissing("k", "mx.itam.deiis.types.Dictionary");
    jcasType.ll_cas.ll_setIntValue(addr, ((Dictionary_Type)jcasType).casFeatCode_k, v);}    
   
    
  //*--------------*
  //* Feature: obj

  /** getter for obj - gets 
   * @generated
   * @return value of the feature 
   */
  public String getObj() {
    if (Dictionary_Type.featOkTst && ((Dictionary_Type)jcasType).casFeat_obj == null)
      jcasType.jcas.throwFeatMissing("obj", "mx.itam.deiis.types.Dictionary");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Dictionary_Type)jcasType).casFeatCode_obj);}
    
  /** setter for obj - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setObj(String v) {
    if (Dictionary_Type.featOkTst && ((Dictionary_Type)jcasType).casFeat_obj == null)
      jcasType.jcas.throwFeatMissing("obj", "mx.itam.deiis.types.Dictionary");
    jcasType.ll_cas.ll_setStringValue(addr, ((Dictionary_Type)jcasType).casFeatCode_obj, v);}    
   
    
  //*--------------*
  //* Feature: textFile

  /** getter for textFile - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTextFile() {
    if (Dictionary_Type.featOkTst && ((Dictionary_Type)jcasType).casFeat_textFile == null)
      jcasType.jcas.throwFeatMissing("textFile", "mx.itam.deiis.types.Dictionary");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Dictionary_Type)jcasType).casFeatCode_textFile);}
    
  /** setter for textFile - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTextFile(String v) {
    if (Dictionary_Type.featOkTst && ((Dictionary_Type)jcasType).casFeat_textFile == null)
      jcasType.jcas.throwFeatMissing("textFile", "mx.itam.deiis.types.Dictionary");
    jcasType.ll_cas.ll_setStringValue(addr, ((Dictionary_Type)jcasType).casFeatCode_textFile, v);}    
  }

    