package tp.pr2.logica;

public class MovimientoComplica extends Movimiento {

	private Ficha[] arrayFichasUndo;
	private Pila pila;
	private Partida partida;
	private int ColumnaMovimiento;
	private Tablero t;
	
	public MovimientoComplica(int donde, Ficha color) {
		jugador = color;
		ColumnaMovimiento = donde;
	}

	@Override
	public Ficha getJugador() {
		// TODO Auto-generated method stub
		return jugador;
	}

	@Override
	public boolean ejecutaMovimiento(Tablero tab) { 
		boolean posible = true;
			//Si la columna esta en rango pasa el if
			if (ColumnaMovimiento > 0 && ColumnaMovimiento < tab.getAncho()+1) {	
				//Si es posible ejecutar movimiento Salta este if y va al else
				if ((tab.fichaUltimaJugada(ColumnaMovimiento) < 0)) {
					posible = false;
				}
				else
				{
					/*
					 * Comprobamos si la ficha se pone en el la posicion más alta del tablero,
					 * de ser así, desplazamos toda la columna y guardamos ultimo valor
					 * 
					 */
					arrayFichasUndo = pila.getArrayFichaUndo(); 
					
					if (pila.posicionUltimaFichaI(ColumnaMovimiento) == 0) {
						System.out.println("Columna llena");
						//Guardamos en el array de Fichas de Pila, la ficha que se va desplazar usando el contador de la pila
						pila.setArrayMoimientosJugadas(pila.getContadorArrayJugadas(), t.getCasilla(t.getAlto()-1, ColumnaMovimiento));	
					
						//Desplazamos toda la columna para ejecutar movimiento complica
						t.desplazarColumnaComplica(ColumnaMovimiento);
		
					}
					tab.setCasilla(ColumnaMovimiento, tab.fichaUltimaJugada(ColumnaMovimiento) + 1, jugador);
				}
			}
			else {System.out.println("llega");
				posible = false;
			}
		return posible;
	}

	@Override
	public void undo(Tablero tab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getColumnaMovimiento() {
		return ColumnaMovimiento;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}