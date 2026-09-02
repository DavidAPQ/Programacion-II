import math

class Estadistica:

    # CONSTRUCTOR
    def __init__(self, datos):
        # ATRIBUTOS
        self.__datos = datos

    # METODOS
    def promedio(self):
        suma = 0
        for i in range(10):
            suma = suma + self.__datos[i]
        return suma / 10

    def desviacion(self):
        promedio = self.promedio()
        suma = 0
        for i in range(10):
            suma = math.pow(self.__datos[i] - promedio, 2) + suma
        return math.sqrt(suma / 9)