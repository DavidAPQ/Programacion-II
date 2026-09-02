class EcuacionLineal:

    #CONSTRUCTOR
    def __init__(self, a, b, c, d, e, f):
        #ATRIBUTOS
        self.__a = a
        self.__b = b
        self.__c = c
        self.__d = d
        self.__e = e
        self.__f = f

    #METODOS
    def tieneSolucion(self):
        determinante = (self.__a * self.__d) - (self.__b * self.__c)
        if (determinante != 0):
            return True
        else:
            return False

    def getX(self):
        num = (self.__e * self.__d) - (self.__b * self.__f)
        den = (self.__a * self.__d) - (self.__b * self.__c)
        return num / den

    def getY(self):
        num = (self.__a * self.__f) - (self.__e * self.__c)
        den = (self.__a * self.__d) - (self.__b * self.__c)
        return num / den        