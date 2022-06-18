package delegation.pattern

class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)