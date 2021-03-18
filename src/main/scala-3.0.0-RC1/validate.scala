package zero.ext
package validate

inline def of10[L,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4], a5: Either[L,A5], a6: Either[L,A6], a7: Either[L,A7], a8: Either[L,A8], a9: Either[L,A9], a10: Either[L,A10])(f: (A1,A2,A3,A4,A5,A6,A7,A8,A9,A10) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value, a5.asInstanceOf[Right[L,A5]].value, a6.asInstanceOf[Right[L,A6]].value, a7.asInstanceOf[Right[L,A7]].value, a8.asInstanceOf[Right[L,A8]].value, a9.asInstanceOf[Right[L,A9]].value, a10.asInstanceOf[Right[L,A10]].value).right
  else
    ls.left
inline def of9[L,A1,A2,A3,A4,A5,A6,A7,A8,A9,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4], a5: Either[L,A5], a6: Either[L,A6], a7: Either[L,A7], a8: Either[L,A8], a9: Either[L,A9])(f: (A1,A2,A3,A4,A5,A6,A7,A8,A9) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4,a5,a6,a7,a8,a9).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value, a5.asInstanceOf[Right[L,A5]].value, a6.asInstanceOf[Right[L,A6]].value, a7.asInstanceOf[Right[L,A7]].value, a8.asInstanceOf[Right[L,A8]].value, a9.asInstanceOf[Right[L,A9]].value).right
  else
    ls.left
inline def of8[L,A1,A2,A3,A4,A5,A6,A7,A8,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4], a5: Either[L,A5], a6: Either[L,A6], a7: Either[L,A7], a8: Either[L,A8])(f: (A1,A2,A3,A4,A5,A6,A7,A8) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4,a5,a6,a7,a8).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value, a5.asInstanceOf[Right[L,A5]].value, a6.asInstanceOf[Right[L,A6]].value, a7.asInstanceOf[Right[L,A7]].value, a8.asInstanceOf[Right[L,A8]].value).right
  else
    ls.left
inline def of7[L,A1,A2,A3,A4,A5,A6,A7,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4], a5: Either[L,A5], a6: Either[L,A6], a7: Either[L,A7])(f: (A1,A2,A3,A4,A5,A6,A7) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4,a5,a6,a7).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value, a5.asInstanceOf[Right[L,A5]].value, a6.asInstanceOf[Right[L,A6]].value, a7.asInstanceOf[Right[L,A7]].value).right
  else
    ls.left
inline def of6[L,A1,A2,A3,A4,A5,A6,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4], a5: Either[L,A5], a6: Either[L,A6])(f: (A1,A2,A3,A4,A5,A6) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4,a5,a6).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value, a5.asInstanceOf[Right[L,A5]].value, a6.asInstanceOf[Right[L,A6]].value).right
  else
    ls.left
inline def of5[L,A1,A2,A3,A4,A5,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4], a5: Either[L,A5])(f: (A1,A2,A3,A4,A5) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4,a5).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value, a5.asInstanceOf[Right[L,A5]].value).right
  else
    ls.left
inline def of4[L,A1,A2,A3,A4,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3], a4: Either[L,A4])(f: (A1,A2,A3,A4) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3,a4).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value, a4.asInstanceOf[Right[L,A4]].value).right
  else
    ls.left
inline def of3[L,A1,A2,A3,B](a1: Either[L,A1], a2: Either[L,A2], a3: Either[L,A3])(f: (A1,A2,A3) => B): Either[Vector[L],B] =
  val ls = List(a1,a2,a3).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value, a3.asInstanceOf[Right[L,A3]].value).right
  else
    ls.left
inline def of2[L,A1,A2,B](a1: Either[L,A1], a2: Either[L,A2])(f: (A1,A2) => B): Either[Vector[L],B] =
  val ls = List(a1,a2).foldLeft(Vector.empty[L]){
    case (acc, Left(x)) => acc :+ x
    case (acc, _) => acc
  }
  if ls.isEmpty then
    f(a1.asInstanceOf[Right[L,A1]].value, a2.asInstanceOf[Right[L,A2]].value).right
  else
    ls.left

