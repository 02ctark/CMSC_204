/**
   Describes any class whose objects can be measured.
*/
public interface Measurable<T>
{
   /**
      Computes the measure of the object.
      @return the measure
   */
   double getMeasure();
}