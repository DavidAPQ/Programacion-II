from Sensor import Sensor

class Camara(Sensor):
    # Atributo de clase
    tipo: str = "Cámara"

    def __init__(self, id: str, resolucion: str):
        Sensor.__init__(self, id)
        # Atributo de instancia
        self.resolucion: str = resolucion