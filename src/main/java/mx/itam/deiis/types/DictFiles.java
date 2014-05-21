

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
public class DictFiles extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DictFiles.class);
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
  protected DictFiles() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public DictFiles(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public DictFiles(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public DictFiles(JCas jcas, int begin, int end) {
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
  //* Feature: path

  /** getter for path - gets 
   * @generated
   * @return value of the feature 
   */
  public String getPath() {
    if (DictFiles_Type.featOkTst && ((DictFiles_Type)jcasType).casFeat_path == null)
      jcasType.jcas.throwFeatMissing("path", "mx.itam.deiis.types.DictFiles");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DictFiles_Type)jcasType).casFeatCode_path);}
    
  /** setter for path - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPath(String v) {
    if (DictFiles_Type.featOkTst && ((DictFiles_Type)jcasType).casFeat_path == null)
      jcasType.jcas.throwFeatMissing("path", "mx.itam.deiis.types.DictFiles");
    jcasType.ll_cas.ll_setStringValue(addr, ((DictFiles_Type)jcasType).casFeatCode_path, v);}    
  }

    