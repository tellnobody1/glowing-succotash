package zero.ext

extension (x: Array[Byte])
  inline def _hex: Array[Byte] =
    val acc = new Array[Byte](x.length * 2)
    var i = 0
    while (i < x.length) {
      val v = x(i) & 0xff
      acc(i * 2) = hexs(v >>> 4)
      acc(i * 2 + 1) = hexs(v & 0x0f)
      i += 1
    }
    acc

  inline def _utf8: String =
    String(x, "utf8")

extension (x: IArray[Byte])
  inline def hex: IArray[Byte] =
    val acc = new Array[Byte](x.length * 2)
    var i = 0
    while (i < x.length) {
      val v = x(i) & 0xff
      acc(i * 2) = hexs(v >>> 4)
      acc(i * 2 + 1) = hexs(v & 0x0f)
      i += 1
    }
    IArray.unsafeFromArray(acc)

  inline def utf8: String =
    String(x.toArray, "utf8")

extension (x: String)
  inline def _utf8: Array[Byte] =
    x.getBytes("utf8").nn

  inline def utf8: IArray[Byte] =
    IArray.unsafeFromArray(x.getBytes("utf8").nn)

private val hexs = "0123456789abcdef".getBytes("ascii").nn
