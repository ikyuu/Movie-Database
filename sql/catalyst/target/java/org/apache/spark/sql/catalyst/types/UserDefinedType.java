package org.apache.spark.sql.catalyst.types;
/**
 * ::DeveloperApi::
 * The data type for User Defined Types (UDTs).
 * <p>
 * This interface allows a user to make their own classes more interoperable with SparkSQL;
 * e.g., by creating a {@link UserDefinedType} for a class X, it becomes possible to create
 * a SchemaRDD which has class X in the schema.
 * <p>
 * For SparkSQL to recognize UDTs, the UDT must be annotated with
 * {@link org.apache.spark.sql.catalyst.annotation.SQLUserDefinedType}.
 * <p>
 * The conversion via <code>serialize</code> occurs when instantiating a <code>SchemaRDD</code> from another RDD.
 * The conversion via <code>deserialize</code> occurs when reading from a <code>SchemaRDD</code>.
 */
public abstract class UserDefinedType<UserType extends java.lang.Object> extends org.apache.spark.sql.catalyst.types.DataType implements scala.Serializable {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Nothing)), TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Any))))
  public   UserDefinedType () { throw new RuntimeException(); }
  /** Underlying storage type for this UDT */
  public abstract  org.apache.spark.sql.catalyst.types.DataType sqlType () ;
  /** Paired Python UDT class, if exists. */
  public  java.lang.String pyUDT () { throw new RuntimeException(); }
  /**
   * Convert the user type to a SQL datum
   * <p>
   * TODO: Can we make this take obj: UserType?  The issue is in ScalaReflection.convertToCatalyst,
   *       where we need to convert Any to UserType.
   */
  public abstract  Object serialize (Object obj) ;
  /** Convert a SQL datum to the user type */
  public abstract  UserType deserialize (Object datum) ;
  public  org.json4s.JsonAST.JValue jsonValue () { throw new RuntimeException(); }
  /**
   * Class object for the UserType
   */
  public abstract  java.lang.Class<UserType> userClass () ;
}
