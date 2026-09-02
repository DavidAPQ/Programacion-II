import time

class Cronometro:

    # CONSTRUCTOR
    def __init__(self):
        # ATRIBUTOS
        self.__inicia = time.time() * 1000
        self.__finaliza = 0

    # METODOS
    def get_inicia(self):
        return self.__inicia

    def get_finaliza(self):
        return self.__finaliza

    def inicia(self):
        self.__inicia = time.time() * 1000

    def detener(self):
        self.__finaliza = time.time() * 1000

    def lapso_de_tiempo(self):
        return self.__finaliza - self.__inicia