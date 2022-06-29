package solution

type Codec struct {
	longUrl  string
	shortUrl string
}

func Constructor() Codec {
	return Codec{"", ""}
}

func (this *Codec) Encode(longUrl string) string {
	return longUrl
}

func (this *Codec) Decode(shortUrl string) string {
	return shortUrl
}
