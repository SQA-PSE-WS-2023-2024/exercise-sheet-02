package de.unistuttgart.iste.sqa.pse.sheet02.presence;

import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.inspector.InspectableSimpleHamsterGame;
import de.hamstersimulator.objectsfirst.inspector.viewmodel.ClassInstanceManager;
import de.hamstersimulator.objectsfirst.inspector.viewmodel.InspectionViewModel;

public abstract class InternalExerciseHamsterGame extends InspectableSimpleHamsterGame {
	public InternalExerciseHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Override to remove have paule not right from the start.
	 */
	@Override
	protected void initializeInspection(final InspectionViewModel inspect) {
		final ClassInstanceManager manager = inspect.getClassInstanceManager();
		manager.addInstance(this, "simpleHamsterGame", true);
		manager.addInstance(this.game, "game", false);
		manager.addInstance(this.game.getTerritory(), "territory", false);
		manager.addClass(Hamster.class, false);
		manager.addClass(Location.class, false);
		manager.addClassesFromCurrentPackage();
	}

	@Override
	protected void run() {
		hamsterRun();
	}

	abstract void hamsterRun();
}
