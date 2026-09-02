import math

class EcuacionLineal:

    #CONSTRUCTOR
    def __init__(self, a, b, c):
        #ATRIBUTOS
        self.__a = a
        self.__b = b
        self.__c = c

    #METODOS
    def getDiscriminante(self):
        discriminante = (self.__b * self.__b) - (4 * self.__a * self.__c)
        return discriminante

    def getRaiz1(self):
        discriminante = self.getDiscriminante()

        if discriminante < 0:
            return 0

        r1 = (-(self.__b) + math.sqrt(discriminante)) / (2 * self.__a)
        return r1

    def getRaiz2(self):
        discriminante = self.getDiscriminante()

        if discriminante < 0:
            return 0

        r2 = (-(self.__b) - math.sqrt(discriminante)) / (2 * self.__a)
        return r2