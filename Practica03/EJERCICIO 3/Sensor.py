class Sensor:
    # Atributo de clase
    tipo: str = "Genérico"

    def __init__(self, id: str):
        # Atributos de instancia
        self.id: str = id
        self.encendido: bool = False

    def activar(self):
        self.encendido = True

    def desactivar(self):
        self.encendido = False