import math

class AlgebraVectorial:

    # Constructor sobrecargado: si no se dan valores, crea el vector (0,0)
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def modulo(self):
        return math.sqrt(self.x ** 2 + self.y ** 2)

    def sumar(self, otro):
        return AlgebraVectorial(self.x + otro.x, self.y + otro.y)

    def restar(self, otro):
        return AlgebraVectorial(self.x - otro.x, self.y - otro.y)

    def multiplicar_escalar(self, r):
        return AlgebraVectorial(self.x * r, self.y * r)

    def producto_punto(self, otro):
        return self.x * otro.x + self.y * otro.y

    def producto_cruz(self, otro):
        # En 2D el producto cruz da un escalar
        return self.x * otro.y - self.y * otro.x

    # Métodos "sobrecargados" es_perpendicular (mismo nombre,
    # se elige la formula con el parametro metodo)
    def es_perpendicular(self, otro, metodo=1):
        tolerancia = 1e-9

        if metodo == 1:
            # a) |a+b| = |a-b|
            return abs(self.sumar(otro).modulo() - self.restar(otro).modulo()) < tolerancia

        elif metodo == 2:
            # b) |a-b| = |b-a|
            return abs(self.restar(otro).modulo() - otro.restar(self).modulo()) < tolerancia

        elif metodo == 3:
            # c) a . b = 0
            return abs(self.producto_punto(otro)) < tolerancia

        elif metodo == 4:
            # d) |a+b|^2 = |a|^2 + |b|^2
            izquierda = self.sumar(otro).modulo() ** 2
            derecha = self.modulo() ** 2 + otro.modulo() ** 2
            return abs(izquierda - derecha) < tolerancia

    # Métodos "sobrecargados" es_paralela
    def es_paralela(self, otro, metodo=1, r=None):
        tolerancia = 1e-9

        if metodo == 1:
            # e) a = r * b
            if r is None:
                return False
            resultado = otro.multiplicar_escalar(r)
            return abs(self.x - resultado.x) < tolerancia and abs(self.y - resultado.y) < tolerancia

        elif metodo == 2:
            # f) a x b = 0
            return abs(self.producto_cruz(otro)) < tolerancia

    # g) Proyeccion_de_a_sobre_b
    def proyeccion_sobre(self, otro):
        factor = self.producto_punto(otro) / (otro.modulo() ** 2)
        return otro.multiplicar_escalar(factor)

    # h) Componente_de_a_en_b
    def componente_en(self, otro):
        return self.producto_punto(otro) / otro.modulo()