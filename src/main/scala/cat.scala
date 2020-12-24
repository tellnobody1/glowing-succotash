package zero.ext.option

package object cat:
  type F[A] = Option[A]

  /* Functor */
  extension [A,B](fn: Function1[A,B])
    // (a -> b) -> f a -> f b
    inline def `<$>`(x: F[A]): F[B] = x.map(fn)

  /* Apply */
  extension [A,B](fn: F[Function1[A,B]])
    // f (a -> b) -> f a -> f b
    inline def <*>(x: => F[A]): F[B] = fn.flatMap(_ `<$>` x)

  // (a -> b -> c) -> f a -> f b -> f c
  inline def lift2[A,B,C](f: A=>B=>C)(a: =>F[A])(b: =>F[B]): F[C] = f `<$>` a <*> b
