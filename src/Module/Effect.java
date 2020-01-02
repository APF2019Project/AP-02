package Module;

public class Effect {
    private int remainingTurn = 0;
    private EffectType effectType;

    private enum EffectType {
    ICE,
    }

    public Effect() {
    }

    public Effect(int remainingTurn, EffectType effectType) {
        this.remainingTurn = remainingTurn;
        this.effectType = effectType;
    }
}
