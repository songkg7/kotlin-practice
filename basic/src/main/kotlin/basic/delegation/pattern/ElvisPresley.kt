package basic.delegation.pattern

class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)