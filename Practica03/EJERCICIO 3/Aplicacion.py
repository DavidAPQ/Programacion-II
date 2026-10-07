from Sensor import Sensor
from Camara import Camara
from SensorLuzLaser import SensorLuzLaser
from VehiculoAutonomo import VehiculoAutonomo

def main():
    sensor = Sensor("S1")
    camara = Camara("C1", "1080p")
    laser = SensorLuzLaser("L1", 100)
    vehiculo = VehiculoAutonomo("V1", "4K", 200)

    print("Sensor:", sensor.tipo, sensor.id, sensor.encendido)
    print("Camara:", camara.tipo, camara.id, camara.resolucion, camara.encendido)
    print("Laser:", laser.tipo, laser.id, laser.alcance, laser.encendido)
    print("Vehiculo:", vehiculo.tipo, vehiculo.id, vehiculo.resolucion, vehiculo.alcance, vehiculo.encendido)

    vehiculo.activar()
    print("Vehiculo tras activar:", vehiculo.encendido)

    vehiculo.desactivar()
    print("Vehiculo tras desactivar:", vehiculo.encendido)

main()