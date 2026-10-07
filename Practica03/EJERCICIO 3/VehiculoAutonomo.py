from Camara import Camara
from SensorLuzLaser import SensorLuzLaser

class VehiculoAutonomo(Camara, SensorLuzLaser):
    # Atributo de clase
    tipo: str = "Vehículo Autónomo"

    def __init__(self, id: str, resolucion: str, alcance: int):
        Camara.__init__(self, id, resolucion)
        SensorLuzLaser.__init__(self, id, alcance)