class Gear

  # attr_reader :chainring, :cog
  def initialize(chainring, cog)
    @chainring = chainring
    @cog = cog
  end

  def ratio
    @chainring / @cog.to_f
  end

end


# オブジェクトを生成
gear = Gear.new(52, 11)

# メソッドを呼び出す
puts gear.ratio   # => 4.7272727272727275




# gear = Gear.new(52, 11)

# puts gear.chainrin