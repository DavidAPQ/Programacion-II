from Sensor import Sensor

class SensorLuzLaser(Sensor):
    # Atributo de clase
    tipo: str = "Luz Laser"

    def __init__(self, id: str, alcance: int):
        Sensor.__init__(self, id)
        # Atributo de instancia
        self.alcance: int = alcance